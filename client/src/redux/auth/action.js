import api from '../../utils/api';
import { setAuthToken, setRefreshToken } from '../../utils/tokens';

const updateUser = (data) => (dispatch) => {
  dispatch({ type: 'EDIT_PROFILE_REQUEST' });
  api({
    method: 'put',
    url: 'users',
    data,
    headers: { 'Content-Type': 'multipart/form-data' }
  })
    .then((profileUpdate) => {
      dispatch({ type: 'EDIT_PROFILE_SUCCESS', payload: profileUpdate });
    })
    .catch(err => {
      dispatch({ type: 'EDIT_PROFILE_ERROR' });
    });
};

const getProfile = () => (dispatch) => {
  dispatch({ type: 'GET_PROFILE_REQUEST' });
  api.get('users/profile')
    .then((profile) => {
      dispatch({ type: 'GET_PROFILE', payload: profile });
    })
    .catch(err => {
      dispatch({ type: 'GET_PROFILE_FAILURE' });
    });
};

const logOut = () => (dispatch) => {
  setAuthToken();
  setRefreshToken();
  dispatch({ type: 'LOGOUT' });
};

const logIn = (values) => (dispatch) => {
  dispatch({ type: 'LOGIN_REQUEST' });
  setAuthToken();
  setRefreshToken();

  api.post('auth/login', values)
    .then((data) => {
      console.log('success log in');
      setAuthToken(data.token);
      setRefreshToken(data.refreshToken);
      dispatch({ type: 'LOGIN_SUCCESS', payload: data.user });
      dispatch(getProfile());
    })
    .catch((err) => {
      dispatch({ type: 'LOGIN_FAILURE' });
    });
};

const forgotPassword = (values) => (dispatch) => {
  dispatch({ type: 'FORGOT_PASSWORD_REQUEST' });

  api
    .post('auth/forgotPassword', values)
    .then(() => {
      dispatch({ type: 'FORGOT_PASSWORD_SUCCESS' });
    })
    .catch((err) => {
      dispatch({ type: 'FORGOT_PASSWORD_FAILURE' });
    });
};

const changePassword = (values, token) => (dispatch) => {
  dispatch({ type: 'CHANGE_PASSWORD_REQUEST' });
  api
    .post('auth/updatePassword', values, { headers: { 'Token': token } })
    .then(() => {
      dispatch({ type: 'CHANGE_PASSWORD_SUCCESS' });
    })
    .catch((err) => {
      dispatch({ type: 'CHANGE_PASSWORD_FAILURE' });
    });
};

export const AUTH_ACTIONS = {
  logIn,
  logOut,
  getProfile,
  forgotPassword,
  changePassword,
  updateUser
};