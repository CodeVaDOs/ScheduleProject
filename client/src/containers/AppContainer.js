import React, {lazy, useMemo} from 'react'
import {useSelector} from 'react-redux'
import PrivateRoute from '../components/PrivateRoute/PrivateRoute'
import Header from '../components/Header/Header'
import {Switch} from 'react-router-dom'
import {Container, makeStyles} from '@material-ui/core'

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
]

const useStyles = makeStyles(() => ({
	container: {
		margin: '22px 0 0 0'
	}
}))

const AppContainer = () => {
	const isAuthorized = useSelector((state) => state.auth.authorized)

	const classes = useStyles()

	const routeComponents = useMemo(
		() =>
			routes.map(({isPublic, isAdminRoute, ...route}) => (
				<PrivateRoute key={route.path} isPublic={isPublic} isAdminRoute={isAdminRoute} {...route} />
			)),
		[]
	)

	return (
		<>
			{isAuthorized && <Header/>}
			<main className={classes.container}>
				<Switch>{routeComponents}</Switch>
			</main>
		</>
	)
}

export default AppContainer