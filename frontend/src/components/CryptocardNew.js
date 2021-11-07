import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import { convertToReadableDate } from '../service/date-service'

export default function CryptocardNew({ coinData }) {
    return (

<Wrapper>
            <ListItem alignItems="flex-start">

                <ListItemAvatar>
                    <Avatar alt="" src={coinData?.imageUrl} />
                </ListItemAvatar>


                <ListItemText
                    primary={coinData?.name}
                    secondary={
                        {coinData && (

                            <Typography
                                sx={{ display: 'inline' }}
                                component="span"
                                variant="body2"
                                color="text.primary"
                            >
                                {coinData?.currentPrice?.usd}

                        Last updated: {convertToReadableDate(coinData?.lastUpdated)}
                            </Typography>
                        )}



                /></Wrapper>
            </ListItem>


    );
}
