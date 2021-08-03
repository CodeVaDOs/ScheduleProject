import React from 'react';

import { useSelector } from 'react-redux';
import { Route, Redirect } from 'react-router-dom';
import CircularProgress from '@material-ui/core/CircularProgress';

const privateRoute = ({ isPublic, isAuthenticated, ...route }) => {
  const { authorized, user, loading } = useSelector((state) => state.auth);

  // if (loading) return <CircularProgress/>

  if ((route.path === '/login' || route.notFound) && authorized && user) return <Redirect to={`/`} />;

  if (isPublic || authorized) {
    return <Route {...route} />;
  }

  return <Redirect to='/login' />;
};

export default privateRoute;