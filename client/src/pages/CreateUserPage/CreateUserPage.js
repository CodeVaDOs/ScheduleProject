import React from 'react'
import {makeStyles, Typography} from '@material-ui/core'
import CreateUserForm from './CreateUserForm'

const useStyles = makeStyles({
	title: () => ({
		padding: '15px'
	})
})

const CreateUserPage = () => {
	const classes = useStyles();

	return (
		<>
			<Typography variant="h4" className={classes.title} align="center">Создание пользователя</Typography>
		</>
	)
}

export default CreateUserPage