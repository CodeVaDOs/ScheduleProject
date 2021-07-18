import React from 'react'
import {makeStyles, Typography} from '@material-ui/core'
import {useDispatch, useSelector} from 'react-redux'
import {AUTH_ACTIONS} from '../../redux/auth/action'
import Button from '@material-ui/core/Button'

const useStyles = makeStyles(theme => ({
	header: props => ({
		backgroundColor: '#fff',
		height: '70px',
		padding: '16px 24px',
		boxSizing: 'border-box',

		boxShadow: '0px 10px 20px rgba(18, 38, 63, 0.0313726)',

		display: 'flex',
		flexDirection: 'row',
		justifyContent: 'space-between',
		alignContent: 'center'
	})
}))

const Header = () => {
	const classes = useStyles()

	const dispatch = useDispatch()

	const user = useSelector(state => state.auth.user)

	const logOut = () => dispatch(AUTH_ACTIONS.logOut())

	return (
		<header className={classes.header}>
			<Typography>Welcome, {user.firstName} {user.lastName}!</Typography>
			<Button onClick={logOut}>Log out</Button>
		</header>
	)
}

export default Header