import { authConstants } from './types';
import { getTokens } from '../../utils/tokens';

const { accessToken } = getTokens();
const INIT_STATE = {
  authorized: Boolean(accessToken),
  loading: false,
  user: {}
};

export default (state = INIT_STATE, action) => {
  switch (action.type) {
    case authConstants.LOGIN_REQUEST:
      return {
        ...state,
        loading: true
      };

    case authConstants.LOGIN_SUCCESS:
      return {
        ...state,
        authorized: true
        // loading: false
      };

    case authConstants.LOGIN_FAILURE:
      return {
        ...state,
        loading: false,
        authorized: false
      };

    case authConstants.GET_PROFILE_REQUEST:
      return {
        ...state,
        loading: true
      };

    case authConstants.GET_PROFILE_SUCCESS:
      return {
        ...state,
        loading: false,
        user: action.payload
      };

    case authConstants.GET_PROFILE_FAILURE:
      return {
        ...state,
        loading: false,
        authorized: false,
        user: {}
      };
    case authConstants.LOGOUT:
      return {
        ...INIT_STATE,
        authorized: false
      };

    default:
      return state;
  }
};