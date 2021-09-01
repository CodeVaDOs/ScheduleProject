import React, { useState } from 'react';
import { Divider, makeStyles } from '@material-ui/core';

const useStyles = makeStyles(() =>  ({
  card: {
    padding: '15px 18px',
    boxSizing: 'border-box',
    border: '1px solid rgba(0, 0, 0, 0.3);',
    marginBottom: '15px'
  }
}))

const ScheduleCard = () => {
  const classes = useStyles();
  const [isOpenCard, setOpenCard] = useState(false);

  const handleOpen = () => setOpenCard(prev => !prev);

  return (
    <div onClick={handleOpen} className={classes.card}>
        test
      {isOpenCard && (
        <>
          <Divider />
          ...
        </>
      )}
    </div>
  );
};

export default ScheduleCard;