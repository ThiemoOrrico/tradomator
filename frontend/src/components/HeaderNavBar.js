import Box from "@mui/material/Box";
import * as React from "react";


export default function HeaderNavBar() {
    return (

            <Box
                sx={{
                    width: '100%',

                    color: '#fff',
                    '& > .MuiBox-root > .MuiBox-root': {
                        p: 1,
                        borderRadius: 0,
                    },
                }}
            >
                <Box
                    sx={{
                        display: 'grid',
                        gridTemplateColumns: 'repeat(3, 1fr)',

                        gridTemplateRows: 'auto',
                        gridTemplateAreas: `"headerLeft headerCenter headerRight"`,
                    }}
                >
                    <Box sx={{gridArea: 'headerLeft', bgcolor: 'primary.main'}}>HeaderLeft</Box>
                    <Box sx={{gridArea: 'headerCenter', bgcolor: 'primary.main'}}>HeaderCenter</Box>
                    <Box sx={{gridArea: 'headerRight', bgcolor: 'primary.main'}}>HeaderRight</Box>

                </Box>

            </Box>


    )
}

