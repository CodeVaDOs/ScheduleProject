import React from 'react';
import { Button, FormControl, InputLabel, makeStyles, MenuItem, Select, TextField } from '@material-ui/core';

const useStyles = makeStyles(() => ({
  root: {
    display: 'flex',
    flexDirection: 'column',
    maxWidth: '400px',
    backgroundColor: '#fff',
    padding: '15px'
  },
  inputField: {
    marginBottom: '15px'
  }
}));

const CreateUserForm = () => {
  const classes = useStyles();
  return (
    <form className={classes.root} noValidate autoComplete="off">
      <TextField className={classes.inputField} variant="outlined" label="First Name" type="text" />
      <TextField className={classes.inputField} variant="outlined" label="Last Name" type="text" />

      <TextField className={classes.inputField} variant="outlined" label="Email" type="email" />
      <TextField className={classes.inputField} variant="outlined" label="Password" type="password" />
      <TextField className={classes.inputField} variant="outlined" label="Repeat password" type="password" />

      <Select variant="outlined" className={classes.inputField}>
        <MenuItem value="STUDENT">Student</MenuItem>
        <MenuItem value="TEACHER">Teacher</MenuItem>
      </Select>


      <Button variant="outlined">Create</Button>
    </form>
  );
};

export default CreateUserForm;