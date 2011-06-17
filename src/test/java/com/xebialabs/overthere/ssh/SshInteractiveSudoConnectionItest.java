/*
 * This file is part of Overthere.
 * 
 * Overthere is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Overthere is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Overthere.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.xebialabs.overthere.ssh;

import static com.xebialabs.overthere.OperatingSystemFamily.UNIX;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.xebialabs.overthere.ConnectionOptions;

public class SshInteractiveSudoConnectionItest extends SshSudoConnectionItestBase {

	@Override
	protected void setTypeAndOptions() {
		type = "ssh_interactive_sudo";
		options = new ConnectionOptions();
		options.set("address", "overthere");
		options.set("username", "untrusted");
		options.set("password", "donttrustme");
		options.set("sudoUsername", "overthere");
		options.set("os", UNIX);
	}

	@Test
	public void hostSessionIsAnSshSudoHostSession() {
		assertThat(connection, instanceOf(SshInteractiveSudoConnection.class));
	}

}
