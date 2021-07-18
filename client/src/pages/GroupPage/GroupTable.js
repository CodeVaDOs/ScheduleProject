import React from 'react'
import {Table, TableBody, TableContainer, TableHead, TableRow} from '@material-ui/core'
import Paper from '@material-ui/core/Paper'
import TableCell from '@material-ui/core/TableCell'

const GroupTable = ({groups}) => {

	const createRow = (group) => ({name: group.name})

	return (
		<TableContainer component={Paper}>
			<Table size="small">
				<TableHead>
					<TableCell>Group Name</TableCell>
				</TableHead>
				<TableBody>
					{groups.map(createRow).map(group => (
						<TableRow key={group.name}>
							<TableCell>{group.name}</TableCell>
						</TableRow>
					))}
				</TableBody>
			</Table>
		</TableContainer>
	)
}

export default GroupTable