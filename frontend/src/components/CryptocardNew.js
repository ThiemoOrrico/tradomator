import * as React from 'react';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';

export default function CryptocardNew({coinData}) {
    return (

    <ListItem >

            <ListItemAvatar>
                <Avatar alt="" src={coinData?.imageUrl}/>
            </ListItemAvatar>


            <ListItemText
                primary={coinData?.symbol}
                secondary={coinData?.id}
                 />

             <ListItemText
                primary={coinData?.currentPrice?.usd}
             />
            <ListItemText secondary='USD'/>


    </ListItem>

    )
}


