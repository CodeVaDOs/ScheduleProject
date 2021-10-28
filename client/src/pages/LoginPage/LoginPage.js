import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AUTH_ACTIONS } from '../../redux/auth/action';
import TextField from '@material-ui/core/TextField';
import { Button, Grid, makeStyles, Typography } from '@material-ui/core';

const useStyles = makeStyles(() => ({
  form: {
    display: 'flex',
    flexDirection: 'column',
    width: '300px',

    position: 'fixed',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%,-50%)'
  },
  field: {
    marginBottom: '10px'
  },
  title: {
    marginBottom: '20px'
  },
  gridRow: {
    textAlign: "center"
  }
}));

const LoginPage = () => {
  const [formValue, setFormValue] = useState({ email: '', password: '' });
  const isLoading = useSelector(state => state.auth.loading);

  const dispatch = useDispatch();

  const classes = useStyles();

  const handleChange = (e) => {
    setFormValue(fv => ({
      ...fv,
      [e.target.name]: e.target.value
    }));
  };

  const handleLogin = () => {
    const { email, password } = formValue;
    dispatch(AUTH_ACTIONS.logIn({ email, password }));
  };

  const handleRegister = () => {
    const { email, password } = formValue;
    dispatch(AUTH_ACTIONS.register({ email, password }));
  };

  return (
    <form onSubmit={handleLogin} className={classes.form}>
      <Typography className={classes.title} variant="h3" align="center">Login</Typography>
      <TextField className={classes.field} variant="outlined" onChange={handleChange} value={formValue.email} type="email" name="email" />
      <TextField className={classes.field} variant="outlined" onChange={handleChange} value={formValue.password} type="password" name="password" />

      <Grid container xs={12}>
        <Grid className={classes.gridRow} item xs={6}>
          <Button type="submit" variant="outlined" onClick={handleLogin} disabled={isLoading}>Authorize</Button>
        </Grid>
        <Grid className={classes.gridRow} item xs={6}>
          <Button type="button" variant="text" onClick={handleRegister} disabled={isLoading}>Register</Button>
        </Grid>
      </Grid>
    </form>
  );
};

export default LoginPage;