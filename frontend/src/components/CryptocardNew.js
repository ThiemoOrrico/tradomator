import * as React from 'react';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';

export default function CryptocardNew({coinData}) {
    return (

        <ListItem sx={{
            display: 'grid',
            gridTemplateColumns: 'repeat(4, 1fr)',
            gridTemplateRows: 'auto',
            gridTemplateAreas: `"headerLeft headerCenter headerRight"`,
        }}>

            <ListItemAvatar>
                <Avatar alt="" src={coinData?.imageUrl}/>
            </ListItemAvatar>


            <ListItemText
                primary={coinData?.symbol}
                secondary={coinData?.id}
            />

            <ListItemText
                sx={{
                    textAlign: "right",
                    m: 2
                }}
                primary={new Intl.NumberFormat('us-US', {
                    style: 'currency',
                    currency: 'USD'
                }).format(coinData?.currentPrice?.usd)}
            />

            <ListItemText secondary='placeholder 24h'/>

        </ListItem>

    )
}


