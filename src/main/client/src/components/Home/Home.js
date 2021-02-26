import React, { useEffect } from 'react';
import useStyles from './styles';
import Posts from '../Posts/Posts';
import { useDispatch, useSelector } from 'react-redux';
import { getPosts } from '../../actions/posts';
import { AppBar } from "@material-ui/core";
import Carousel from "../Carousel/Carousel";
import data from '../../data';

const Home = () => {
	const dispatch = useDispatch();
	const classes = useStyles();

	useEffect(() => {
		dispatch(getPosts());
	}, [dispatch]);

	const posts = useSelector(state => state.posts);

	return (
		<div className={classes.home}>
			<Carousel />
			<Posts posts={posts}/>
		</div>
	)
}

export default Home;