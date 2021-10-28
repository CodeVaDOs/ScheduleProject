import React from 'react';
import { useFetch } from '../../hooks/useFetch';
import { useParams } from 'react-router-dom/cjs/react-router-dom';
import { Link as RouterLink } from 'react-router-dom';
import { Breadcrumbs, Link, Typography } from '@material-ui/core';

const GroupDetailsPage = () => {

  const { groupId } = useParams();

  const [{ data, loading }, getData] = useFetch({
    initData: [],
    url: `/users?groupId=${groupId}`,
    method: 'GET'
  });

  return (
    <>
      <Breadcrumbs aria-label="breadcrumb">
        <Link underline="hover" color="inherit" to="/groups" component={RouterLink}>
          Groups
        </Link>
        <Typography color="text.primary">Group Details</Typography>
      </Breadcrumbs>
      <ul>
        {loading && 'Loading...'}
        {data.map(u => (
          <li>{u.firstName} {u.lastName}</li>
        ))}
      </ul>
    </>
  );
};

export default GroupDetailsPage;