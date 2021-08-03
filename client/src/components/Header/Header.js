import React from 'react';
import { AppBar, IconButton, makeStyles, Typography } from '@material-ui/core';
import { useDispatch, useSelector } from 'react-redux';
import { AUTH_ACTIONS } from '../../redux/auth/action';
import Button from '@material-ui/core/Button';
import clsx from 'clsx';

const useStyles = makeStyles(theme => ({
  header: props => ({
    backgroundColor: '#fff',
    color: 'black',
    padding: '16px 24px',
    boxSizing: 'border-box',
    height: '68px',

    boxShadow: '0px 10px 20px rgba(18, 38, 63, 0.0313726)',

    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignContent: 'center',
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  }),
  appBarShift: props => ({
    marginLeft: props.drawerWidth,
    width: `calc(100% - ${props.drawerWidth}px - 20px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  })
}));

const Header = ({isSidebarOpen, drawerWidth, handleDrawer}) => {
  const classes = useStyles({drawerWidth});

  const dispatch = useDispatch();

  const user = useSelector(state => state.auth.user);

  const logOut = () => dispatch(AUTH_ACTIONS.logOut());

  return (
    <AppBar className={clsx(classes.header, isSidebarOpen && classes.appBarShift)}>
      <Typography onClick={handleDrawer}>Welcome, {user.firstName} {user.lastName}!</Typography>
      <Button onClick={logOut}>Log out</Button>
    </AppBar>
  );
};

export default Header;