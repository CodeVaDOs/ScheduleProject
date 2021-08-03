import React, { lazy, useMemo, useState } from 'react';
import PrivateRoute from '../components/PrivateRoute/PrivateRoute';
import { Switch } from 'react-router-dom';

const routes = [
  {
    isPublic: false,
    isAdminRoute: false,
    exact: true,
    path: '/',
    component: lazy(() => import('../pages/HomePage/HomePage'))
  },
  {
    isPublic: false,
    isAdminRoute: true,
    exact: true,
    path: '/groups',
    component: lazy(() => import('../pages/GroupPage/GroupPage'))
  },
  {
    isPublic: true,
    isAdminRoute: false,
    exact: true,
    path: '/login',
    component: lazy(() => import('../pages/LoginPage/LoginPage'))
  },
  {
    path: '/',
    notFound: true
  }
];

const AppContainer = () => {
  const routeComponents = useMemo(
    () =>
      routes.map(({ isPublic, isAdminRoute, ...route }) => (
        <PrivateRoute key={route.path} isPublic={isPublic} isAdminRoute={isAdminRoute} {...route} />
      )),
    []
  );

  return (
    <>
      <Switch>{routeComponents}</Switch>
    </>
  );
};

export default AppContainer;