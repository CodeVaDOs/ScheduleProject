import React from 'react'
import TextField from '@material-ui/core/TextField'
import SelectInput from '@material-ui/core/Select/SelectInput'
import Select from '@material-ui/core/Select'
import Button from '@material-ui/core/Button'
import {makeStyles} from '@material-ui/core'

const useStyles = makeStyles({
	form: () => ({
		display: 'flex',
		flexDirection: 'column',
		padding: '15px'
	}),
	field: () => ({
		marginBottom: '15px'
	})
})

const CreateUserForm = () => {
	const classes = useStyles();

	return (
		<form className={classes.form}>
			<TextField name="firstName" className={classes.field} variant="outlined" label="Имя"/>
			<TextField name="lastName" className={classes.field} variant="outlined" label="Фамилия"/>
			<TextField name="email" className={classes.field} type="email" variant="outlined" label="Почта"/>
			<TextField name="password" className={classes.field} type="password" variant="outlined" label="Пароль"/>
			<TextField name="repeatPassword" className={classes.field} type="password" variant="outlined" label="Повторите пароль"/>
			<Select name="group" label="Группа" className={classes.field} />
			<Button className={classes.field} variant="outlined">Создать</Button>
		</form>
	)
}

export default CreateUserForm