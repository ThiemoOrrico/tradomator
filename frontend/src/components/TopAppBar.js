import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import {AccountCircle} from "@material-ui/icons";
import SettingsTwoToneIcon from '@mui/icons-material/SettingsTwoTone';

export default function TopAppBar() {
    return (
            <Box sx={{
                flexGrow: 1
            }}>

                <AppBar>
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
                            sx={{gridArea: 'headerLeft', justifyContent: "flex-start", mr: 2}}
                        >
                            <MenuIcon/>
                        </IconButton>
                        <Box
                            sx={{
                                display: 'flex',
                                justifyContent: 'center',
                                p: 1,
                                m: 1
                            }}
                        >
                            <Typography variant="h5" component="div" sx={{
                                gridArea: 'headerCenter', justifyContent: "flex-end"
                            }}>
                                trad
                            </Typography>

                            <SettingsTwoToneIcon fontSize="large"/>

                            <Typography variant="h5" component="div" sx={{
                                gridArea: 'headerCenter', justifyContent: "flex-end"
                            }}>
                                mator
                            </Typography>
                        </Box>

                        <Button
                            href='/login'
                            size="small"
                            aria-label="account of current user"
                            aria-controls="menu-appbar"
                            aria-haspopup="true"
                            color="inherit"
                            sx={{gridArea: 'headerRight', justifyContent: 'flex-end'}}

                        >
                            <AccountCircle/>
                        </Button>

                    </Toolbar>
                </AppBar>

            </Box>
    );
}