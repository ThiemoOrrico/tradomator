import * as React from 'react';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';

export default function WalletCard({balance}) {
    return (

        <ListItem >

            <ListItemText
                primary={balance?.asset}
            />

            <ListItemText
                primary={balance?.free}
            />

            <ListItemText
                primary={balance?.locked}
            />


        </ListItem>

    )
}


