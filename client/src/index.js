import React, { Suspense } from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import store from './redux/store';
import { Provider } from 'react-redux';
import { BrowserRouter } from 'react-router-dom';
import { MuiThemeProvider } from '@material-ui/core';

const reduxStore = store();

ReactDOM.render(
  <React.StrictMode>
    <Provider store={reduxStore}>
      <Suspense fallback={'Loading...'}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
      </Suspense>
    </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);
