import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core';
import { useFetch } from '../../hooks/useFetch';
import GroupTable from './GroupTable';
import CreateGroupModal from './CreateGroupModal';
import { useDispatch, useSelector } from 'react-redux';
import { GROUPS_ACTIONS } from '../../redux/groups/action';
import { useModal } from '../../hooks/useModal';
import GroupInfoModal from './GroupInfoModal';

const useStyles = makeStyles(() => ({
  container: {}
}));

const GroupPage = () => {
  const classes = useStyles();
  const createModal = useModal();
  const infoModal = useModal();

  const dispatch = useDispatch();
  const groupsList = useSelector(state => state.groups.groupsList);


  useEffect(() => {
    dispatch(GROUPS_ACTIONS.getGroups());
  }, []);


  return (
    <div className={classes.container}>
      <GroupTable groups={groupsList} createModal={createModal} infoModal={infoModal} />

      <CreateGroupModal handler={createModal} />
      <GroupInfoModal handler={infoModal} />
    </div>
  );
};

export default GroupPage;