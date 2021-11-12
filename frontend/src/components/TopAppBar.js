import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import {AccountCircle} from "@material-ui/icons";

export default function TopAppBar() {
    return (
        <Box sx={{ flexGrow: 1
        }}>
            <AppBar >

                <Toolbar sx={{
                    display: 'grid',
                    gridTemplateColumns: 'repeat(3, 1fr)',
                    gridTemplateRows: 'auto',
                    gridTemplateAreas: `"headerLeft headerCenter headerRight"`,

                }}
                >
                    <IconButton
                        size="large"
                        edge="start"
                        color="inherit"
                        aria-label="menu"
                        sx={{gridArea: 'headerLeft',justifyContent: "flex-start" , bgcolor: 'primary.main', mr: 2 }}
                    >
                        <MenuIcon />
                    </IconButton>

                    <Typography variant="h6" component="div" sx={{
                        gridArea: 'headerCenter', justifyContent: "flex-end" , bgcolor: 'primary.main'
                         }}>
                        Placeholder Logo
                    </Typography>

                    <Button

                        href='/Login'
                        size="small"
                        aria-label="account of current user"
                        aria-controls="menu-appbar"
                        aria-haspopup="true"
                        color="inherit"
                        sx={{gridArea: 'headerRight', justifyContent:'flex-end' ,bgcolor: 'primary.main'}}

                    >
                        <AccountCircle />
                    </Button>





                </Toolbar>
            </AppBar>
        </Box>
    );
}