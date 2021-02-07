import React from 'react';
import useStyles from './styles';
import logo from '../../images/logo.png';
import IconButton from "@material-ui/core/IconButton";
import { Toolbar, Typography, AppBar, InputBase } from "@material-ui/core";
import MenuIcon from '@material-ui/icons/Menu';
import SearchIcon from '@material-ui/icons/Search';

import Carousel from '../Carousel/Carousel';

const Navbar = () => {
	const classes = useStyles();

	return (
		<div>
			<AppBar className={classes.appBar}>
				<Toolbar>
					<IconButton
						edge="start"
						className={classes.menuButton}
						color="inherit"
						aria-label="open drawer"
					>
						<MenuIcon />
					</IconButton>
					<img src={logo} alt="icon" height="50" />
					<Typography className={classes.title} variant="h6">
						&nbsp; (((CringeCinema)))
					</Typography>
					<div className={classes.search}>
						<div className={classes.searchIcon}>
							<SearchIcon />
						</div>
						<InputBase
							placeholder="Search…"
							classes={{
								root: classes.inputRoot,
								input: classes.inputInput,
							}}
							inputProps={{ 'aria-label': 'search' }}
						/>
					</div>
				</Toolbar>
			</AppBar>
			<Carousel />
		</div>
	);
}

export default Navbar;