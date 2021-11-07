import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';

import PropTypes from 'prop-types';
import HeaderNavBar from "./HeaderNavBar";
import MainContent from "./MainContent";
import FooterNavBar from "./FooterNavBar";
import CoingeckoOverview from "./CoingeckoOverview";
import useGeckoCoins from "../hooks/useGeckoCoins";


export default function LayoutGrid() {

    const { coins } =
        useGeckoCoins()


    return (
        <React.Fragment>
            <CssBaseline />
            <Container maxWidth="md" height= '100%'>

                <Box sx={{
                    display: 'grid',
                    gridTemplateRows: 'auto',
                    bgcolor: '#cfe8fc',
                    height: '100vh' }}>

                    <Box
                        sx={{

                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'flex-start',
                            p: 0,
                            m: 0,
                            bgcolor: 'blue',
                        }}
                    >
                        <HeaderNavBar sx={{height: 1/10}}/>
                        <CoingeckoOverview coins={coins} sx={{maxHeight: 8/10}}/>
                        <FooterNavBar sx={{height: 1/10}}/>

                    </Box>

                </Box>

            </Container>
        </React.Fragment>
    );
}
