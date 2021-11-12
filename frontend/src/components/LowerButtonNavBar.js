import * as React from 'react';
import Box from '@mui/material/Box';
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';
import RestoreIcon from '@mui/icons-material/Restore';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ArchiveIcon from '@mui/icons-material/Archive';
import Paper from '@mui/material/Paper';

function refreshMessages() {
    const getRandomInt = (max) => Math.floor(Math.random() * Math.floor(max));

    return Array.from(new Array(1)).map(
        () => messageExamples[getRandomInt(messageExamples.length)],
    );
}

export default function LowerButtonNavBar() {
    const [value, setValue] = React.useState(0);
    const ref = React.useRef(null);
    const [messages, setMessages] = React.useState(() => refreshMessages());

    React.useEffect(() => {
        ref.current.ownerDocument.body.scrollTop = 0;
        setMessages(refreshMessages());
    }, [value, setMessages]);

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
                    <BottomNavigationAction label="Home" icon={<RestoreIcon />} />
                    <BottomNavigationAction label="Spot" icon={<FavoriteIcon />} />
                    <BottomNavigationAction label="Wallet" icon={<ArchiveIcon />} />
                </BottomNavigation>
            </Paper>
        </Box>
    );
}

const messageExamples = [
    {
        primary: 'Brunch this week?',
        secondary: "I'll be in the neighbourhood this week. Let's grab a bite to eat",
        person: '/static/images/avatar/5.jpg',
    }

];
