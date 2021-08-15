import React from 'react';
import { makeStyles, Modal as UIModal, Typography } from '@material-ui/core';


const useStyles = makeStyles((theme) => ({
  modal: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
  },
  paper: {
    backgroundColor: '#fff',
    borderRadius: '7px',
    padding: 0,
    outline: 'none',
    maxWidth: '700px',
    minWidth: '400px'
  },
  modalHeader: {
    borderBottom: '1px solid #74788d',
    padding: '10px 15px',
    position: 'relative'
  },
  modalBody: {
    padding: '15px 15px'
  },
  closeButton: {
    cursor: 'pointer',
    width: '20px',
    height: '20px',
    position: 'absolute',
    top: '50%',
    right: '15px',
    transform: 'translateY(-50%)',

    "&::before, &::after": {
      position: 'absolute',
      top: '50%',
      left: '50%',
      content: "''",
      transform: 'translate(-50%, -50%) rotate(-45deg)',
      width: '20px',
      height: '1px',
      borderRadius: '2px',
      background: '#343A40',
    },
    "&::after": {
      transform: 'translate(-50%, -50%) rotate(45deg)'
    }
  }
}));

const Modal = ({ isOpen, handleModal, headerTitle, children }) => {
  const classes = useStyles();

  return (
    <UIModal
      open={isOpen}
      onClose={handleModal}
      className={classes.modal}
    >
      <div className={classes.paper}>
        <div className={classes.modalHeader}>
          <Typography >{headerTitle}</Typography>
          <a onClick={handleModal} className={classes.closeButton}/>
        </div>
        <div className={classes.modalBody}>
          {children}
        </div>
      </div>
    </UIModal>
  );
};

export default Modal;