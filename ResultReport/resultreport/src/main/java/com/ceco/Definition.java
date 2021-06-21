package com.ceco;

public class Definition {

    public long TopPerformersThreshold;
    public Boolean UseExperienceMultiplier;
    public long PeriodLimit;

    public Definition (long TopPerformersThreshold, Boolean UseExperienceMultiplier, long PeriodLimit) {
        this.TopPerformersThreshold = TopPerformersThreshold;
        this.UseExperienceMultiplier = UseExperienceMultiplier;
        this.PeriodLimit = PeriodLimit;
    }

}
