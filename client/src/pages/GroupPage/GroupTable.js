import React from 'react';
import { Table, TableBody, TableContainer, TableFooter, TableHead, TableRow } from '@material-ui/core';
import Paper from '@material-ui/core/Paper';
import TableCell from '@material-ui/core/TableCell';
import Button from '@material-ui/core/Button';

const GroupTable = ({ groups, createModal, infoModal }) => {

  const createRow = (group) => ({ name: group.name });

  return (
    <TableContainer component={Paper}>
      <Table size="small">
        <TableHead>
          <TableCell>Название группы</TableCell>
        </TableHead>
        <TableBody>
          {groups.map(createRow).map(group => (
            <TableRow key={group.name}>
              <TableCell>{group.name}</TableCell>
            </TableRow>
          ))}
        </TableBody>
        <TableFooter>
          <TableRow>
            <Button onClick={createModal.handleModal}>Создать группу</Button>
          </TableRow>
        </TableFooter>
      </Table>
    </TableContainer>
  );
};

export default GroupTable;