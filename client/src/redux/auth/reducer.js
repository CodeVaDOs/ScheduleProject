import {authConsts} from './types'
import {getTokens} from '../../utils/tokens'

const {accessToken} = getTokens()
const INIT_STATE = {
	authorized: Boolean(accessToken),
	loading: false,
	user: {}
}

export default (state = INIT_STATE, action) => {
	switch (action.type) {
	case authConsts.LOGIN_REQUEST:
		return {
			...state,
			loading: true,
		}

	case authConsts.LOGIN_SUCCESS:
		return {
			...state,
			authorized: true
			// loading: false
		}

	case authConsts.LOGIN_FAILURE:
		return {
			...state,
			loading: false,
			authorized: false
		}

	case authConsts.GET_PROFILE_REQUEST:
		return {
			...state,
			loading: true,
		}

	case authConsts.GET_PROFILE:
		return {
			...state,
			loading: false,
			user: action.payload,
		}

	case authConsts.GET_PROFILE_FAILURE:
		return {
			...state,
			loading: false,
			authorized: false,
			user: {}
		}
	case authConsts.EDIT_PROFILE_ERROR:
		return {
			...state,
			loading: false,
		}
	case authConsts.EDIT_PROFILE_SUCCESS:
		return {
			...state,
			user: action.payload,
			loading: false
		}
	case authConsts.EDIT_PROFILE_REQUEST:
		return {
			...state,
			loading: true
		}
	case authConsts.LOGOUT:
		return {
			...INIT_STATE,
			authorized: false,
		}

	case authConsts.FORGOT_PASSWORD_REQUEST:
		return {
			...state,
			loading: true,
		}

	case authConsts.FORGOT_PASSWORD_SUCCESS:
		return {
			...state,
			loading: false
		}

	case authConsts.FORGOT_PASSWORD_FAILURE:
		return {
			...state,
			loading: false
		}

	case authConsts.CHANGE_PASSWORD_REQUEST:
		return {
			...state,
			loading: true,
		}

	case authConsts.CHANGE_PASSWORD_SUCCESS:
		return {
			...state,
			loading: false
		}

	case authConsts.CHANGE_PASSWORD_FAILURE:
		return {
			...state,
			loading: false
		}
	default:
		return state
	}
};