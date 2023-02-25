/*
 * FileCommand.java - Implementation of file: command
 * Copyright (C) 2000 Romain Guy
 * romain.guy@jext.org
 * http://www.jext.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.jext.console.commands;

import org.jext.Jext;
import org.jext.Utilities;
import org.jext.console.Console;

/**
 * This command opens a file in the text area.
 * @author Romain Guy
 */

public class FileCommand extends Command
{
  private static final String COMMAND_NAME = "file:";

  public String getCommandName()
  {
    return COMMAND_NAME + "filename";
  }

  public String getCommandSummary()
  {
    return Jext.getProperty("console.file.command.help");
  }

  public boolean handleCommand(Console console, String command)
  {
    if (command.startsWith(COMMAND_NAME))
    {
      String argument = command.substring(5);
      if (argument.length() > 0)
        console.getParentFrame().open(Utilities.constructPath(argument));
      else
        console.error(Jext.getProperty("console.missing.argument"));
      return true;
    }

    return false;
  }
}

// End of FileCommand.java
