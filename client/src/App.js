import React, { useState, Suspense } from 'react';
import AppContainer from './containers/AppContainer';
import { CssBaseline, makeStyles } from '@material-ui/core';
import Header from './components/Header/Header';
import Sidebar from './components/Sidebar/Sidebar';
import { useSelector } from 'react-redux';


const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex'
  },
  container: props => ({
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
    padding: `${68 + 15}px 20px 0 ${(props.open ? props.drawerWidth : 0) + 20}px`,
    transition: theme.transitions.create('padding', {
      easing: theme.transitions.easing.sharp,
      duration: props.open ? theme.transitions.duration.enteringScreen : theme.transitions.duration.leavingScreen
    })
  })
}));

const drawerWidth = 240;

function App() {
  const isAuthorized = useSelector((state) => state.auth.authorized);
  const [open, setOpen] = useState(true);

  const handleDrawer = () => setOpen(prev => !prev);

  const classes = useStyles({ open, drawerWidth });
  return (
    <div className={classes.root}>
      <CssBaseline />
      {isAuthorized && <Header
        isSidebarOpen={open}
        handleDrawer={handleDrawer}
        drawerWidth={drawerWidth} />}

      {isAuthorized && <Sidebar
        open={open}
        drawerWidth={drawerWidth} />}

      <div className={classes.container}>
        <Suspense fallback={'Loading...'}>
          <AppContainer />
        </Suspense>
      </div>
    </div>
  );
}

export default App;
