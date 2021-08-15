import { groupsConstants } from './types';

const INIT_STATE = {
  groupsList: [],
  loading: false
};

export default (state = INIT_STATE, action) => {
  switch (action.type) {
    case groupsConstants.GET_GROUPS_REQUEST:
      return {
        ...state,
        loading: true
      };

    case groupsConstants.GET_GROUPS_SUCCESS:
      return {
        ...state,
        groupsList: action.payload.groupsList,
        loading: false
      };

    case groupsConstants.GET_GROUPS_FAILURE:
      return {
        ...state,
        loading: false
      };


    case groupsConstants.CREATE_GROUP_REQUEST:
      return {
        ...state,
        loading: true
      };

    case groupsConstants.CREATE_GROUP_SUCCESS:
      return {
        ...state,
        groupsList: [...state.groupsList, action.payload.group],
        loading: false
      };

    case groupsConstants.CREATE_GROUP_FAILURE:
      return {
        ...state,
        loading: false
      };
    default:
      return state;
  }
};