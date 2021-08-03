import React from 'react';
import { makeStyles } from '@material-ui/core';
import { useFetch } from '../../hooks/useFetch';
import GroupTable from './GroupTable';

const useStyles = makeStyles(() => ({
  container: {}
}));

const GroupPage = () => {
  const classes = useStyles();

  const [{ data, loading }, getData] = useFetch({
    initData: [],
    url: '/groups',
    method: 'GET'
  });

  console.log(data);

  return (
    <div className={classes.container}>
      <GroupTable groups={data} />
    </div>
  );
};

export default GroupPage;