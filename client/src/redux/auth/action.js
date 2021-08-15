import api from '../../utils/api';
import { setAuthToken, setRefreshToken } from '../../utils/tokens';
import { authConstants } from './types';

const getProfile = () => (dispatch) => {
  dispatch({ type: authConstants.GET_PROFILE_REQUEST });
  api.get('users/profile')
    .then((profile) => {
      dispatch({ type: authConstants.GET_PROFILE_SUCCESS, payload: profile });
    })
    .catch(err => {
      dispatch({ type: authConstants.GET_PROFILE_FAILURE});
    });
};

const logOut = () => (dispatch) => {
  setAuthToken();
  setRefreshToken();
  dispatch({ type: authConstants.LOGOUT });
};

const logIn = (values) => (dispatch) => {
  dispatch({ type: authConstants.LOGIN_REQUEST });
  setAuthToken();
  setRefreshToken();

  api.post('auth/login', values)
    .then((data) => {
      console.log('success log in');
      setAuthToken(data.token);
      setRefreshToken(data.refreshToken);
      dispatch({ type: authConstants.LOGIN_SUCCESS, payload: data.user });
      dispatch(getProfile());
    })
    .catch((err) => {
      dispatch({ type: authConstants.LOGIN_FAILURE });
    });
};


export const AUTH_ACTIONS = {
  logIn,
  logOut,
  getProfile
};