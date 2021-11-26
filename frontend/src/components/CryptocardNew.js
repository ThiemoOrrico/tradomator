import * as React from 'react';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';

export default function CryptocardNew({coinData}) {
    return (

        <ListItem sx={{
            display: 'grid',
            gridTemplateColumns: 'repeat(3, 1fr)',
            gridTemplateRows: 'auto',
            ml: 1,
        }}>

            <ListItemAvatar>
                <Avatar alt="" src={coinData?.imageUrl}/>
            </ListItemAvatar>


            <ListItemText
                sx={{
                    textAlign: "left",
                    alignItems:"left",
                }}
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


        </ListItem>

    )
}


