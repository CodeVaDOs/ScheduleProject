import React from 'react';
import { Drawer, ListItem, ListItemIcon, ListItemText, makeStyles } from '@material-ui/core';
import clsx from 'clsx';
import { Dashboard, Group } from '@material-ui/icons';
import { Link } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
  drawerPaperClose: {
    overflowX: 'hidden',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  drawerPaper: props => ({
    width: props.open ? props.drawerWidth : 0,
    whiteSpace: 'nowrap',
    paddingTop: '68px',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  }),
  link: {
    textDecoration: 'none',
    color: 'inherit'
  }

}));

const listOfLinks =  [
  {
    to: '/',
    linkText: 'Dashboard',
    linkIcon: <Dashboard/>
  },
  {
    to: '/groups',
    linkText: 'Groups',
    linkIcon: <Group/>
  },
]

const Sidebar = ({ open, drawerWidth }) => {
  const classes = useStyles({ drawerWidth, open });

  return (
    <Drawer
      variant="permanent"
      open={open}
      classes={{
        paper: clsx(!open && classes.drawerPaperClose, classes.drawerPaper)
      }}
      anchor="left">

      {listOfLinks.map(l => (
        <Link className={classes.link} to={l.to}>
          <ListItem button>
            <ListItemIcon>
              {l.linkIcon}
            </ListItemIcon>
            <ListItemText primary={l.linkText}/>
          </ListItem>
        </Link>
      ))}
    </Drawer>
  );
};

export default Sidebar;