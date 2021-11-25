import * as React from 'react';
import Box from '@mui/material/Box';
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';
import RestoreIcon from '@mui/icons-material/Restore';
import Paper from '@mui/material/Paper';
import TrendingUpIcon from '@mui/icons-material/TrendingUp';
import AccountBalanceWalletIcon from '@mui/icons-material/AccountBalanceWallet';

export default function BottomNavBar() {

    const [value, setValue] = React.useState(0);
    const ref = React.useRef(null);

    return (
        <Box sx={{ pb: 7 }} ref={ref}>

            <Paper sx={{ position: 'fixed', bottom: 0, left: 0, right: 0 }} elevation={3}>
                <BottomNavigation
                    showLabels
                    value={value}
                    onChange={(event, newValue) => {
                        setValue(newValue);
                    }}
                >
                    <BottomNavigationAction label="Home" icon={<RestoreIcon  />} href="/"/>
                    <BottomNavigationAction label="Spot Trading" icon={<TrendingUpIcon />} />
                    <BottomNavigationAction label="Wallet" icon={<AccountBalanceWalletIcon  />} href="/wallet"/>
                </BottomNavigation>
            </Paper>
        </Box>
    );
}
