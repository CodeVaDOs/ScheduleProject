import React from 'react';
import { AppBar, Icon, IconButton, makeStyles, Typography } from '@material-ui/core';
import { useDispatch, useSelector } from 'react-redux';
import { AUTH_ACTIONS } from '../../redux/auth/action';
import Button from '@material-ui/core/Button';
import clsx from 'clsx';
import { ExitToApp, Menu, MenuBook } from '@material-ui/icons';

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
    alignItems: 'center',
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    })
  }),
  appBarShift: props => ({
    marginLeft: props.drawerWidth,
    width: `calc(100% - ${props.drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen
    })
  }),
  rightContainer: {
    display: 'flex',
    alignContent: 'center'
  },
  icon: {
    paddingLeft: 0
  },
  exitButton: {
    padding: 0,
    minWidth: 'unset',
    marginLeft: '20px'
  }
}));

const Header = ({ isSidebarOpen, drawerWidth, handleDrawer }) => {
  const classes = useStyles({ drawerWidth });

  const dispatch = useDispatch();

  const user = useSelector(state => state.auth.user);

  const logOut = () => dispatch(AUTH_ACTIONS.logOut());

  return (
    <AppBar className={clsx(classes.header, isSidebarOpen && classes.appBarShift)}>
      <Menu onClick={handleDrawer}/>
      <div className={classes.rightContainer}>
        <Typography variant="h6">Welcome, {user.firstName} {user.lastName}!</Typography>
        <Button className={classes.exitButton} onClick={logOut}><ExitToApp/></Button>
      </div>
    </AppBar>
  );
};

export default Header;