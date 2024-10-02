import Header from "./Header";
import { Outlet } from "react-router-dom";
import { getVideos } from "../api/video";
import { useState, useEffect } from "react";

const Layout = () => {
  const [videos, setVideos] = useState([]);
  const videoAPI = async () => {
    const result = await getVideos();
    setVideos(result.data);
  };
  useEffect(() => {
    videoAPI();
  }, []);
  return (
    <>
      <Header />
      <Outlet context={{ videos }} />
    </>
  );
};

export default Layout;
