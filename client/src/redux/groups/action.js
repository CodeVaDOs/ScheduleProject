import { groupsConstants } from './types';
import api from '../../utils/api';

const getGroups = () => (dispatch) => {
  dispatch({ type: groupsConstants.GET_GROUPS_REQUEST });
  api.get('/groups')
    .then(groups => {
      dispatch({ type: groupsConstants.GET_GROUPS_SUCCESS, payload: { groupsList: groups } });
    })
    .catch(err => {
      dispatch({ type: groupsConstants.GET_GROUPS_FAILURE });
    });
};

const createGroup = (group) => (dispatch) => {
  dispatch({ type: groupsConstants.CREATE_GROUP_REQUEST });
  api.post('/groups', JSON.stringify(group), {
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(group => {
      dispatch({ type: groupsConstants.CREATE_GROUP_SUCCESS, payload: { group } });
    })
    .catch(err => {
      dispatch({ type: groupsConstants.CREATE_GROUP_FAILURE });
    });
};

export const GROUPS_ACTIONS = {
  getGroups,
  createGroup
};