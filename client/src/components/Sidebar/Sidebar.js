import React from 'react';
import { Divider, Drawer, Icon, ListItem, ListItemIcon, ListItemText, makeStyles, Typography } from '@material-ui/core';
import clsx from 'clsx';
import { Chat, Dashboard, Group, Schedule, SupervisedUserCircle } from '@material-ui/icons';
import { Link, useLocation } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
  drawerPaperClose: {
    overflowX: 'hidden',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    })
  },
  drawerPaper: props => ({
    width: props.open ? props.drawerWidth : 0,
    whiteSpace: 'nowrap',
    backgroundColor: '#2A3042',
    border: 'none',
    color: '#A6B0CF',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen
    })
  }),
  link: {
    textDecoration: 'none',
    color: 'inherit'
  },
  logoContainer: {
    height: '68px',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    borderBottom: '1px solid #A6B0CF',
    boxSizing: 'border-box'
  }
}));


const listOfLinks = [
  {
    to: '/',
    linkText: 'Главная',
    linkIcon: Dashboard
  },
  {
    to: '/schedule',
    linkText: 'Расписание',
    linkIcon: Schedule
  },
  {
    to: '/chat',
    linkText: 'Сообщения',
    linkIcon: Chat
  },
  {
    to: '/groups',
    linkText: 'Группы',
    linkIcon: Group
  },
  {
    to: '/users',
    linkText: 'Пользователи',
    linkIcon: SupervisedUserCircle
  }
];

const Sidebar = ({ open, drawerWidth }) => {
  const classes = useStyles({ drawerWidth, open });

  const activePath = useLocation().pathname;

  const getIconColorStyle = (isActive) => ({ color: isActive ? '#fff' : '#A6B0CF' });

  return (
    <Drawer
      variant="permanent"
      open={open}
      classes={{
        paper: clsx(!open && classes.drawerPaperClose, classes.drawerPaper)
      }}
      anchor="left">
      <div className={classes.logoContainer}>
        <Typography>Scheduler</Typography>
      </div>
      {listOfLinks.map(l => (
        <Link style={getIconColorStyle(l.to === activePath)} className={classes.link} to={l.to}>
          <ListItem button>
            <ListItemIcon>
              <Icon component={l.linkIcon} style={getIconColorStyle(l.to === activePath)} />
            </ListItemIcon>
            <ListItemText primary={l.linkText} />
          </ListItem>
        </Link>
      ))}
    </Drawer>
  );
};

export default Sidebar;