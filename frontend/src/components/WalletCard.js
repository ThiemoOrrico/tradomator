import * as React from 'react';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';

export default function WalletCard({balance}) {
    return (

        <ListItem  sx={{
            display: 'grid',
            gridTemplateColumns: 'repeat(2, 1fr)',
            gridTemplateRows: 'auto',
            ml:2,

        }}>


            <ListItemText
                primary={balance?.asset}
            />

            <ListItemText
                primary={balance?.free}
            />


        </ListItem>

    )
}


