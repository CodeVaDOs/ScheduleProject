import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';
import { applyMiddleware, combineReducers, createStore } from 'redux';

import authReducer from './auth/reducer';
import groupsReducer from './groups/reducer';
import { getTokens, setAuthToken } from '../utils/tokens';
import { AUTH_ACTIONS } from './auth/action';


const reducer = combineReducers({
  auth: authReducer,
  groups: groupsReducer
});

export default () => {
  const { accessToken } = getTokens();
  const store = createStore(
    reducer,
    composeWithDevTools(applyMiddleware(thunk))
  );

  if (accessToken) {
    setAuthToken(accessToken);
    store.dispatch(AUTH_ACTIONS.getProfile());
  }

  return store;
};