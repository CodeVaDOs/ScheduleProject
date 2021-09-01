import React from 'react';
import { Grid } from '@material-ui/core';
import ScheduleCard from './ScheduleCard';

const SchedulePage = () => {
  return (
    <div>
      <Grid container spacing={3}>
        <Grid item xs={2}>
          Понедельник
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
        </Grid>
        <Grid item xs={2}>
          Вторник
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
        </Grid>
        <Grid item xs={2}>
          Среда
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
        </Grid>
        <Grid item xs={2}>
          Четверг
          <ScheduleCard/>
          <ScheduleCard/>
        </Grid>
        <Grid item xs={2}>
          Пятница
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
          <ScheduleCard/>
        </Grid>
        <Grid item xs={2}>
          1
        </Grid>
        </Grid>
    </div>
  );
};

export default SchedulePage;