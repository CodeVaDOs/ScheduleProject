import React, { useEffect, useState } from 'react';
import { Button, makeStyles, MenuItem, Select, TextField } from '@material-ui/core';
import Modal from '../../components/Modal/Modal';
import { useFetch } from '../../hooks/useFetch';
import { useDispatch } from 'react-redux';
import { GROUPS_ACTIONS } from '../../redux/groups/action';


const useStyles = makeStyles((theme) => ({
  form: {},
  inputField: {
    width: '100%'
  },
  createButton: {
    display: 'block',
    margin: '15px auto 0'
  }
}));

const CreateGroupModal = ({ handler }) => {
  const classes = useStyles();
  const dispatch = useDispatch();

  const { isOpen, handleModal } = handler;

  const [formData, setFormData] = useState({
    name: ''
  });

  const handleChange = (e) => {
    setFormData(prev => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const createGroup = (e) => {
    e.preventDefault();
    if (formData.name) {
      dispatch(GROUPS_ACTIONS.createGroup(formData));
      handleModal();
    }
  };

  return (
    <Modal isOpen={isOpen} handleModal={handleModal} headerTitle="Создание группы">
      <form onSubmit={createGroup} className={classes.form} noValidate autoComplete="off">
        <TextField onChange={handleChange} className={classes.inputField} variant="outlined" name="name" label="Название группы" type="text" />

        <Button type="submit" className={classes.createButton} variant="outlined">Создать</Button>
      </form>
    </Modal>
  );
};

export default CreateGroupModal;