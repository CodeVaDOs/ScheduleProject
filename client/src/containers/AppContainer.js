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
    isPublic: false,
    isAdminRoute: true,
    exact: true,
    path: '/groups/:groupId',
    component: lazy(() => import('../pages/GroupDetailsPage/GroupDetailsPage'))
  },
  {
    isPublic: false,
    isAdminRoute: true,
    exact: true,
    path: '/users',
    component: lazy(() => import('../pages/UsersPage/UsersPage'))
  },
  {
    isPublic: false,
    isAdminRoute: false,
    exact: true,
    path: '/chat',
    component: lazy(() => import('../pages/ChatPage/ChatPage'))
  },
  {
    isPublic: false,
    isAdminRoute: false,
    exact: true,
    path: '/schedule',
    component: lazy(() => import('../pages/SchedulePage/SchedulePage'))
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