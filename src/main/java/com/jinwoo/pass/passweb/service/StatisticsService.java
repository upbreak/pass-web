package com.jinwoo.pass.passweb.service;

import com.jinwoo.pass.passweb.dto.AggregatedStatistics;
import com.jinwoo.pass.passweb.dto.ChartData;
import com.jinwoo.pass.passweb.repository.StatisticsRepository;
import com.jinwoo.pass.passweb.utils.LocalDateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public ChartData makeChartData(LocalDateTime to) {
        LocalDateTime from = to.minusDays(10);

        List<AggregatedStatistics> aggregatedStatistics = statisticsRepository.findByStatisticsAtBetweenAndGroupBy(from, to);

        List<String> labels = new ArrayList<>();
        List<Long> attendedCount = new ArrayList<>();
        List<Long> cancelledCount = new ArrayList<>();

        for(AggregatedStatistics statistics : aggregatedStatistics){
            labels.add(LocalDateTimeUtils.format(statistics.getStatisticsAt(), LocalDateTimeUtils.MM_DD));
            attendedCount.add(statistics.getAttendedCount());
            cancelledCount.add(statistics.getCancelledCount());
        }

        return new ChartData(labels, attendedCount, cancelledCount);
    }
}
