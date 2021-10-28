import React from 'react';
import { Table, TableBody, TableContainer, TableFooter, TableHead, TableRow } from '@material-ui/core';
import Paper from '@material-ui/core/Paper';
import TableCell from '@material-ui/core/TableCell';
import Button from '@material-ui/core/Button';
import { Link } from 'react-router-dom';

const GroupTable = ({ groups, createModal, infoModal }) => {




  return (
    <TableContainer component={Paper}>
      <Table size="small">
        <TableHead>
          <TableCell>Название группы</TableCell>
          <TableCell>Количество студентов</TableCell>
        </TableHead>
        <TableBody>
          {groups.map(group => (
              <TableRow key={group.name}>
                <TableCell><Link to={`/groups/${group.id}`}>{group.name}</Link></TableCell>
                <TableCell>{group.countStudents}</TableCell>
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