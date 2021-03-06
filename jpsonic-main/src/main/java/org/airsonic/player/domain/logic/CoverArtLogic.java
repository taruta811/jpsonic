/*
 This file is part of Jpsonic.

 Jpsonic is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Jpsonic is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Jpsonic.  If not, see <http://www.gnu.org/licenses/>.

 Copyright 2019 (C) tesshu.com
 */
package org.airsonic.player.domain.logic;

import org.airsonic.player.domain.Album;
import org.airsonic.player.domain.Artist;
import org.airsonic.player.domain.Playlist;
import org.airsonic.player.domain.PodcastChannel;
import org.springframework.stereotype.Component;

/**
 * A class that hides the key generation logic of CoverArt.
 * This class is used from the controller.
 * In other words, the key generated by this class is not stored in the persistence layer.
 */
@Component
public class CoverArtLogic {

    private static final String ALBUM_COVERART_PREFIX = "al-";
    private static final String ARTIST_COVERART_PREFIX = "ar-";
    private static final String PLAYLIST_COVERART_PREFIX = "pl-";
    private static final String PODCAST_COVERART_PREFIX = "pod-";

    public boolean isAlbum(String id) {
        return id.startsWith(ALBUM_COVERART_PREFIX);
    }

    public boolean isArtist(String id) {
        return id.startsWith(ARTIST_COVERART_PREFIX);
    }

    public boolean isPlaylist(String id) {
        return id.startsWith(PLAYLIST_COVERART_PREFIX);
    }

    public boolean isPodcast(String id) {
        return id.startsWith(PODCAST_COVERART_PREFIX);
    }

    public int getAlbumId(String id) {
        return Integer.valueOf(id.replace(ALBUM_COVERART_PREFIX, ""));
    }

    public int getArtistId(String id) {
        return Integer.valueOf(id.replace(ARTIST_COVERART_PREFIX, ""));
    }

    public int getPlaylistId(String id) {
        return Integer.valueOf(id.replace(PLAYLIST_COVERART_PREFIX, ""));
    }

    public int getPodcastId(String id) {
        return Integer.valueOf(id.replace(PODCAST_COVERART_PREFIX, ""));
    }

    public String createKey(Artist artist) {
        return ARTIST_COVERART_PREFIX + artist.getId();
    }

    public String createKey(Album album) {
        return ALBUM_COVERART_PREFIX + album.getId();
    }

    public String createKey(Playlist playlist) {
        return PLAYLIST_COVERART_PREFIX + playlist.getId();
    }

    public String createKey(PodcastChannel channel) {
        return PODCAST_COVERART_PREFIX + channel.getId();
    }

}
