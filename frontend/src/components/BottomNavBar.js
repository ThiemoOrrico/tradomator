import * as React from 'react';
import Box from '@mui/material/Box';
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';
import RestoreIcon from '@mui/icons-material/Restore';
import Paper from '@mui/material/Paper';
import TrendingUpIcon from '@mui/icons-material/TrendingUp';
import AccountBalanceWalletIcon from '@mui/icons-material/AccountBalanceWallet';
import {useHistory} from "react-router-dom";


export default function BottomNavBar() {

    let history = useHistory();

    const [currentRoute, setCurrentRoute] = React.useState("home"); //value = route

    const handleChange = (event, value) => { setCurrentRoute(value) }
    const handleWalletClick = () => { history.push("/wallet") }
    const handleHomeClick = () => { history.push("/home") }

    return (
        <Box sx={{pb: 7}} >

            <Paper sx={{position: 'fixed', bottom: 0, left: 0, right: 0}} elevation={3}>
                <BottomNavigation
                    showLabels
                    value={currentRoute}
                    onChange={handleChange}
                    sx={{
                        "& .Mui-selected, .Mui-selected > svg": {
                            color: "#80b61e"
                        }
                    }}

                >
                    <BottomNavigationAction value="home" label="Home" icon={<RestoreIcon />} onClick={ ()=> handleHomeClick()}/>
                    <BottomNavigationAction value="spotTrading" label="Spot Trading" icon={<TrendingUpIcon/>}/>
                    <BottomNavigationAction value="wallet" label="Wallet" icon={<AccountBalanceWalletIcon/>} onClick={ handleWalletClick}/>
                </BottomNavigation>
            </Paper>
        </Box>
    );
}
